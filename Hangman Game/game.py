from hangmanfinal import*
from random import*



class Game():
    def __init__(self):
        self.hangman = Hangman()
        self.listName = ""
        self.words = []
        self.guesslist = []
        self.newList = ['animals', 'clothes', 'transportation', 'veggies']
        while (self.listName not in self.newList):
            self.listName = input("Choose clothes, animals, veggies, or transportation: ").strip()
        fname = self.listName + ".txt"
        handle = open(fname, "r")
        for name in handle:
            self.words.append(name.strip())

        self.reset()
    
    def reset(self):
        self.randWord = "word"
        self.userWord = []
        self.guess = ""
        self.usedletter = []
        self.letters = []
        
    def drawHangmanPole(self):
        self.hangman.clearscreen()
        self.hangman.drawTable("brown")

    def getRandomWord(self):
        seed()
        a = 0
        b = len(self.words) - 1

        self.temp = randint(a, b)
        self.randword = self.words[self.temp]
        
    def printWord(self):
        print(self.userWord)

    def drawHangman(self, chance):
        c = Hangman()
        num = 10 - chance
        if(num == 1):
            c.drawFace(30)
        elif(num == 2):
            c.drawBody()
        elif(num == 3):
            c.drawLeftLeg()
        elif(num == 4):
            c.drawLeftFoot()
        elif(num == 5):
            c.drawRightLeg()
        elif(num == 6):
            c.drawRightFoot()
        elif(num == 7):
            c.drawRightHand()
        elif(num == 8):
            c.drawRightPalm()
        elif(num == 9):
            c.drawLeftHand()
        elif(num == 10):
            c.drawLeftPalm()
            
        else:
            bye()

    def drawHangman2(self, chance):
        num = 10 - chance
        if(num == 1):
            self.hangman.drawFace(30)
        elif(num == 2):
            self.hangman.drawBody()
        elif(num == 3):
            self.hangman.drawLeftLeg()
        elif(num == 4):
            self.hangman.drawLeftFoot()
        elif(num == 5):
            self.hangman.drawRightLeg()
        elif(num == 6):
            self.hangman.drawRightFoot()
        elif(num == 7):
            self.hangman.drawRightHand()
        elif(num == 8):
            self.hangman.drawRightPalm()
        elif(num == 9):
            self.hangman.drawLeftHand()
        elif(num == 10):
            self.hangman.drawLeftPalm()
            
        else:
            bye()
        

    def playGame(self):
        chance = 10
        self.getRandomWord()
        length = len(self.randword) 
        self.listWord = list("-" * length)
        win = False
        
        while(chance > 0):
            do = False
            self.userWord = ' '.join(self.listWord)
            self.printWord()
            self.guess = input("Letter: ")
            if(self.guess in self.guesslist):
                        chance = chance -1
                        self.drawHangman2(chance)
                        do = True
            self.guesslist.append(self.guess)
            if self.guess not in self.usedletter:
                self.usedletter.append(self.guess)
            guessed = False   
            for i in range(len(self.randword)):
                if (self.guess == self.randword[i]):
                    self.listWord[i] = self.guess
                    guessed = True
                    
                            
            if(guessed == True):
                user = ''.join(self.listWord)
                if(user == self.randword):
                    win = True
                    chance = 0
                    print("Congratulations!!!")
                    print("\nThe correct word is '", self.randword,"'")
                
            else:
                if(do == False):
                 chance = chance - 1
                #self.drawHangman(chance)
                 self.drawHangman2(chance)
            if(chance > 0):
                print("You have", chance, "more tries.")
            print("Letters used: ", ", ".join(self.usedletter))
                
        if(win == False):
            print("\nSorry you lost! The correct word was '", self.randword,"'")

    def playLoop(self):
        play_again = "y"
        while (play_again == "y"):
            self.drawHangmanPole()
            self.reset()
            self.playGame()
            play_again = input("Would you like to play again? y/n: ")
            
        print("Thanks for playing, bye!")
        
def driverCode():
      g = Game()
      g.playLoop()
      
driverCode()

