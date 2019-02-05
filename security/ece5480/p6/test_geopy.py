# Test geopy.geocoders Nominatim
# https://pypi.org/project/geopy/
# Install: pip install geopy (from https://pypi.org/project/geopy/)
# Install: conda install -c conda-forge geopy (from https://anaconda.org/conda-forge/geopy)

from geopy.geocoders import Nominatim


geolocator = Nominatim(user_agent="specify_your_app_name_here")
location = geolocator.reverse("52.509669, 13.376294")
print(location.address)

