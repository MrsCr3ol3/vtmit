from bs4 import BeautifulSoup
import requests, sys, webbrowser

print("Searching for " + "+".join(sys.argv[1:]))
myres = requests.get("https://scholar.google.com/scholar?hl=en&q=" + "+".join(sys.argv[1:]) + "&*")
soup = BeautifulSoup(myres.text, "html.parser")
elems = soup.select(".gs_rt a")
num = min(len(elems), 5)
for i in range(num):
 print(elems[i].get("href"))
 webbrowser.open(elems[i].get("href"))