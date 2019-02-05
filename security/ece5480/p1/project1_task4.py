import subprocess
ipaddr = ["8.8.8.8", "1.1.1.1", "8.8.4.4", "139.130.4.5", "192.168.1.134"]

for x in ipaddr:
	proc = subprocess.Popen( ['ping', '-n', '3', x], stdout=subprocess.PIPE)
	stdout, stderr = proc.communicate()
	if proc.returncode == 0:
		print('{} is UP'.format(x))
	else:
		print('{} is DOWN <OR> there is a NETWORKERROR'.format(x))