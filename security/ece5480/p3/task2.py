
from collections import Counter
file = open('dns_log_file.txt', 'r')

dnslist = []

# for line in file:
	# if ('error') not in line:
		# if 'xfer-in' not in line:
			# if 'general' not in line:
				# if 'lame-servers' not in line:
					# if 'warning' not in line:
						# if 'no longer listening' not in line:
							# if 'notify:' not in line:
								# dnslist.append(line)

for line in file:
	if 'queries: info: client' in line:
		dnslist.append(line)
		
file.close()

iplist = []

for line in dnslist:
	index = line.find('#')
	newline = line[47:index]
	iplist.append(newline)
	
uniq_ip = {}

for item in iplist:
	uniq_ip[item] = uniq_ip.get(item, 0) + 1
	
domain_list = []

for line in dnslist:
	index = line.find('query: ') + 7
	index2 = line.find(' IN ')
	newline = line[index:index2]
	if 'in-addr.arpa' not in newline:
		domain_list.append(newline)

uniq_domain = {}

for item in domain_list:
	uniq_domain[item] = uniq_domain.get(item, 0) + 1

common_ip = max(uniq_ip.keys(), key=(lambda k: uniq_ip[k]))
common_domain = max(uniq_domain.keys(), key=(lambda k: uniq_domain[k]))

long_domain = max(domain_list, key = lambda x : len(x))
short_domain = min(domain_list, key = lambda x : len(x))
	

print ("\n")
print ("\n")
print ('> Earliest Record Time and Date: ' + dnslist[0][0:24])
print ('> Last Record Time and Date: ' + dnslist[-1][0:24])	
print ('> Total Number of Records: ',  len(dnslist))
print ('> Total Unique Ip: ', len(uniq_ip))
print ('> Most Common IP: ', common_ip, ', Count: ', uniq_ip[common_ip])
print ('> Total Number of Domain: ', len(uniq_domain))
print ('> Most Common Domain: ',common_domain, ', Count: ', uniq_domain[common_domain])
print ('> Most Unusual Domain: \"'+ long_domain + "\" or \"" + short_domain + "\"")
print ("\n")

with open('filtered_dns.txt', 'w') as ff:
	for item in dnslist:
		ff.write(item)