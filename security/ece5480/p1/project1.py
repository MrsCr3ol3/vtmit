import requests

def getPageRequests(url):
	myres = requests.get(url)	
	return myres.text

userinput = input("Please Enter your URL:  ")
myText = getPageRequests(userinput)

print (myText)
