from timeit import default_timer as timer

file1 = open("RECOVERED_PASSWORD_HASHES.txt")

recovered_hashes = file1.readlines()

file1.close()

file2 = open("RAINBOW_TABLE.txt")

indexed_hashes = list(enumerate(file2))

file2.close()

file3 = open("10K_PLAINTEXT_PASSWORDS.txt")

plaintext_passwords = file3.readlines()

file3.close()

for candidate in recovered_hashes:
   found = False
   startTimer = timer()
   for i,hash in indexed_hashes:
       if candidate.rstrip() == hash.rstrip():
			found = True
			endTimer = timer()
			x = (endTime - startTime)*1000000
			print("MATCH: hash # " + hash + " = " + plaintext_passwords[i])
			print("The search took" + x + "microseconds")
		if found == False:
			endTimer = timer()
			x = (endTime - startTime)*1000000
			print("NO MATCH FOUND FOR ", candidate.rstrip())
			print("The search took" + x + "microseconds")
