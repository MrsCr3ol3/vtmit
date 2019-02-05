from geopy.geocoders import Nominatim
import urllib.request
import json


urllib.request.urlretrieve('https://isc.sans.edu/block.txt', 'block.txt')

file = open('block.txt','r')

lines = [line.rstrip() for line in file.readlines()]

file.close()

nums = {'0','1','2','3','4','5','6','7','8','9'}

ip_list = []
for line in lines:
    if (line[0] in nums):
        ip_list.append(line.split("\t",2)[0])

#print(ip_list)

lat_longs = []
geolocator = Nominatim(user_agent="specify_your_app_name_here")

for ip in ip_list:
    headers = {'Accept': 'application/json' }
    get_url = "https://api.ipdata.co/" + ip + "?api-key=bee7895cc80dfbac7aa9f53028cca4a9e95ce23d13eff3d7206d405d"

    request = urllib.request.Request(get_url, headers=headers)
    response_body = urllib.request.urlopen(request).read()

    ip_data = json.loads(response_body)

    lat_long = []
    latitude = ip_data['latitude']
    longitude = ip_data['longitude']

    lat_long.append(latitude)
    lat_long.append(longitude)
    lat_longs.append(lat_long)


for lat_long in lat_longs:
    lat_long_string = str(lat_long[0]) + ", " + str(lat_long[1])
    location = geolocator.reverse(lat_long_string)
    print(location.address)
    print("\n")

