
from turtle import*

class Hangman:
    def __init__(self):
        self.t = Turtle()
        self.length = 300
        self.width = 50
        self.color = "black"
        self.color1 = "Old Lace"

    def drawTable(self,user_color):
        self.t.pensize(5)
        self.t.penup()
        self.t.goto(-20, -20)
        self.t.pendown()
        self.color = user_color
        self.t.color(self.color)
        self.t.fd(self.width)
        self.t.fd(self.width)
        self.t.backward(self.width)
        self.t.left(90)
        self.t.fd(self.length)
        self.t.right(90)
        self.t.fd(self.width)
        self.t.fd(self.width)
        self.t.right(90)
        self.t.fd(self.width + 7)
        self.t.ht()

    def drawFace(self,user_radius):
        self.t.color(self.color)
        self.t.penup()
        self.t.goto(127,176)
        self.t.pendown()
        self.t.begin_fill()
        self.t.left(90)
        self.t.circle(user_radius)
        self.t.fillcolor(self.color1)
        self.t.end_fill()
        self.t.ht()

    
    def drawBody(self):
        #self.color = user_color
        self.t.color(self.color)
        self.t.pensize(5)
        self.t.penup()
        self.t.goto(125,172)
        self.t.pendown()
        self.t.right(90)
        self.t.fd(self.width)
        self.t.fd(self.width)
        self.t.ht()

    def drawLeftLeg(self):
        #self.color = user_color
        self.t.left(40)
        self.t.fd(self.width)
        self.t.ht()

    def drawLeftFoot(self):
        #self.color = user_color
        self.t.left(90)
        self.t.fd(10)
        self.t.backward(10)
        self.t.ht()
        #self.t.backward(10)

    def drawRightLeg(self):
        self.t.penup()
        self.t.goto(125,72)
        self.t.pendown()
        self.t.right(170)
        self.t.fd(self.width)
        self.t.ht()

    def drawRightFoot(self):
        self.t.right(90)
        self.t.fd(10)
        self.t.ht()

    def drawRightHand(self):
        self.t.penup()
        self.t.goto(126,150)
        self.t.pendown()
        self.t.right(170)
        self.t.fd(self.width)
        self.t.ht()

    def drawRightPalm(self):
        self.t.left(90)
        self.t.fd(10)
        self.t.backward(10)
        self.t.ht()

    def drawLeftHand(self):
        self.t.penup()
        self.t.goto(126,150)
        self.t.pendown()
        self.t.left(150)
        self.t.fd(self.width)
        self.t.ht()

    def drawLeftPalm(self):
        self.t.right(90)
        self.t.fd(10)
        self.t.backward(10)
        self.t.ht()

    def clearscreen(self):
        self.t.reset()
        self.t.ht()
        

       
            
        
