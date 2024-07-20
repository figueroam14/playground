TryHackMe | CrackTheHash

https://tryhackme.com/r/room/crackthehash


writeups:

https://sckull.github.io/posts/hashes/




##### check the type of hash: 

```
hash-identifier
# use to identify the type of hash, enter hash when prompted

# can view the hash modes here...
https://hashcat.net/wiki/doku.php?id=example_hashes

```



#### crack the hashes

```
# hash-mode 0 = MD5
hashcat -m 0 hash1.txt /usr/share/wordlists/rockyou.txt 

# hash-mode 100 = SHA1
hashcat -m 100 hash2.txt /usr/share/wordlists/rockyou.txt 

# hash-mode 1470 = sha256
hashcat -m 1470 hash3.txt /usr/share/wordlists/rockyou.txt 

# hash-identifer could not find hash type, so used an online tool: 
https://www.tunnelsup.com/hash-analyzer/
type was: bcrypt
hashcat -m 3200 hash4.txt /usr/share/wordlists/rockyou.txt 

### Cracking process was taking too long so canceled, est time was 13 days LOL





```



