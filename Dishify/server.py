import csv
import random
from flask import Flask, render_template, render_template_string, request


app = Flask(__name__)

index_html = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dishify</title>
    <link rel="stylesheet" href="{{ url_for('static', filename='style.css') }}">
</head>
<body>
    <img src='https://cdn.glitch.global/dfcec574-1f8c-472c-bce0-3d6fece2099b/dishifylogo.png?v=1701401298204' width='1000'>
    <h1>Menu:</h1>
    <form method="post" action="/process_form">
        <label for="diet_type">Choose your diet:</label>
        <select name="diet_type" id="diet_type">
            <option value="Vegetarian">Vegetarian</option>
            <option value="Vegan">Vegan</option>
            <option value="Paleo">Paleo</option>
            <option value="Keto">Keto</option>
            <option value="Mediterranean">Mediterranean</option>
            <option value="Low Carb">Low Carb</option>
            <option value="No Sugar">No Sugar</option>
        </select>
        <select name="intensity_type" id="intensity_type">
            <option value="Light">Light</option>
            <option value="Medium">Medium</option>
            <option value="Heavy">Heavy</option>
        </select>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
"""

meal_plan_html = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dishify Meal Plan</title>
    <link rel="stylesheet" href="{{ url_for('static', filename='style.css') }}">
</head>
<body>
    <img src='https://cdn.glitch.global/dfcec574-1f8c-472c-bce0-3d6fece2099b/dishifylogo.png?v=1701401298204' width='1000'>
    <h2>{{ content }}</h2>
    
    <h3>Recommended Meal Plan:</h3>
    <ul>
    {% for day, meals in weekly_meal_plan.items() %}
        <li><strong>{{ day }}:</strong>
            {% for meal_info in meals %}
                {{ meal_info['meal'] }}
                <ul>
                    <li>Key Ingredient: {{ meal_info['ingredients'] }}</li>
                </ul>
            {% endfor %}
        </li>
    {% endfor %}
    </ul>

    <form method="get" action="/">
        <button type="submit">Go Back</button>
    </form>
</body>
</html>
"""

def get_7_day_meal_plan(diet_type, intensity_type):
    days_of_week = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    weekly_meal_plan = {day: [] for day in days_of_week}
    ingredients_dict = {}

    with open('ingredients.csv', 'r', newline='', encoding='utf-8') as ingredient_file:
        ingredient_reader = csv.DictReader(ingredient_file)
        for ingredient_row in ingredient_reader:
            meal = ingredient_row['Meal']
            ingredients = ingredient_row['Ingredients'].split(', ')
            ingredients_dict[meal] = ingredients

    with open('foodList.csv', 'r', newline='', encoding='utf-8') as meal_file:
        meal_reader = csv.DictReader(meal_file)
        available_meals = [meal_row['Meal'] for meal_row in meal_reader if
                           meal_row['Diet Type'] == diet_type and meal_row['Intensity'] == intensity_type]

        meal_file.seek(0)
        meal_reader = csv.DictReader(meal_file)

        for meal_row in meal_reader:
            if meal_row['Diet Type'] == diet_type and meal_row['Intensity'] == intensity_type:
                day = meal_row['Day']
                meal = meal_row['Meal']
                ingredients = ingredients_dict.get(meal, [])
                weekly_meal_plan.setdefault(day, []).append({'meal': meal, 'ingredients': ingredients})

        for day in days_of_week:
            if not weekly_meal_plan[day]:
                if available_meals:
                    chosen_meal = random.choice(available_meals)
                    ingredients = ingredients_dict.get(chosen_meal, [])
                    weekly_meal_plan[day].append({'meal': chosen_meal, 'ingredients': ingredients})

    weekly_meal_plan = {day: meals for day, meals in weekly_meal_plan.items() if meals}

    return weekly_meal_plan






@app.route('/')
def index():
    return render_template_string(index_html)

@app.route('/process_form', methods=['POST'])
def process_form():
    diet_type = request.form.get('diet_type')
    intensity_type = request.form.get('intensity_type')

    weekly_meal_plan = get_7_day_meal_plan(diet_type, intensity_type)

    if diet_type in ['Vegetarian', 'Vegan', 'Paleo', 'Keto', 'Mediterranean', 'Low Carb', 'No Sugar']:
        return render_template_string(meal_plan_html, title=diet_type, content=f'Recommended {diet_type} meals for {intensity_type} intensity:', weekly_meal_plan=weekly_meal_plan)
    else:
        return render_template_string(error_html, title='Error', content='Input did not match any option.')

if __name__ == "__main__":
    app.run(debug=True)
