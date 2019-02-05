# Test of ipdata.co geolocation API
# Note: you must sign up for a free API key -- replace "your_key" with your key
# Limitations: The free tier allows 1500 requests a day or 45,000 requests a month--> it is up to you to make sure you do not violate these restrictions.


import urllib.request

headers = {
  'Accept': 'application/json'
}
request = urllib.request.Request('https://api.ipdata.co/8.8.8.8?api-key=bee7895cc80dfbac7aa9f53028cca4a9e95ce23d13eff3d7206d405d', headers=headers)

response_body = urllib.request.urlopen(request).read()

print(response_body)
                
 