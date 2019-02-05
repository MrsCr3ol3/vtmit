#ECE 5480 Fall 2018 # Project 1

import requests
from bs4 import BeautifulSoup
myres = requests.get("https://www.orionscache.com/books")
soup = BeautifulSoup(myres.text, "html.parser")
#print(soup)
links = soup.findAll("a")

for i in range(10):
	print (links[i])