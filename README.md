# Kids Playground 
> Kids Playground is a kid-friendly mobile application designed to make learning fun and interactive. The app helps cultivate strong mathematical skills while offering engaging activities like a drawing playground and a game called Catch the Fruits.

## Features
- **Math Quiz** : Simple and easy to understand questions aimed towards improving arithmetic operations of kids.
   - It contains 5 Options : 1.Addition, 2.Substraction, 3.Division, 4.Multiplication and 5.Random Operations.

- **Fruit Find** : A simple game to catch fruits that randomly appears on the screen, helps kid's to improve their focus and reflexes.
- **Playground** : A amazing drawing canvas that let's your kid to unleash their creative desire on your phone screen.
  - It provides the features like undo, redo, clear screen, colour pallate, and brush width.

## Quick  
Math Quiz | Fruit Find | Playground
:-: | :-: | :-:
<video src ="https://github.com/user-attachments/assets/39aac2e9-ff68-4a50-b592-0c44d8dd974f" width="120px"> </video>| <video src ="https://github.com/user-attachments/assets/df0728a7-5834-4f37-8fea-a1fcb30ddf56"  width="120px"></video> | <video src="https://github.com/user-attachments/assets/f16e998e-79cf-4b16-9575-2c65d3d8fb70"  width="120px"></video>

## Programming 
Let's Dive into programming terms!

Prerequisites :
Before we begin try to learn about these topics : Intents, XML, Acitivites, DataBinding and Kotlin.
> [!NOTE]
> Checkout [Drawing Canvas](https://github.com/Miihir79/DrawingCanvas-Library) Library which we have used for creating Playground feature.


### Ui
For Ui design i have used MaterialDesign guidelines for margins, padding and etc with custom touch for button styling. 

Button Style(Material Card View) | Text Style
:-: | :-:
https://github.com/Nishu-workspace/KidsPlayground/blob/5e68901aad2729ea4f12288824a0f010769d84a2/app/src/main/res/values/styles.xml#L4-L21 | https://github.com/Nishu-workspace/KidsPlayground/blob/5e68901aad2729ea4f12288824a0f010769d84a2/app/src/main/res/values/styles.xml#L22-L26

That's it, you don't need to change any thing more.
> [!TIP]
> Font used for project are [Fredoka](https://fonts.google.com/specimen/Fredoka).
> </br> if you want to use any other font, i highly suggest you to use google fonts.(for copyright reasons)

XML File list :
- [activity_main.xml](app/src/main/res/layout/activity_main.xml) : Home Screen
- [activity_operators.xml](app/src/main/res/layout/activity_operators.xml) : Operators/ Match Quiz
   - [activity_addition_game.xml](app/src/main/res/layout/activity_addition_game.xml) : Addition Game
   - [activity_substraction_game.xml](app/src/main/res/layout/activity_substraction_game.xml) : Substraction Game
   - [activity_division_game.xml](app/src/main/res/layout/activity_division_game.xml) : Division Game
   - [activity_multiply_game.xml](app/src/main/res/layout/activity_multiply_game.xml) : Multiply Game
- [activity_catch_fruit.xml](app/src/main/res/layout/activity_catch_fruit.xml) : Find Fruit Game
- [activity_draw_canvas.xml](app/src/main/res/layout/activity_draw_canvas.xml) : Drawing Canvas 







