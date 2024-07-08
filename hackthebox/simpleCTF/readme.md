TryHackMe | SimpleCTF

https://tryhackme.com/r/room/easyctf

WriteUps:

https://medium.com/@akerkar34/simple-ctf-tryhackme-walkthrough-13fae8abe32d


#### nmap scan
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

# gobuster scan
`gobuster dir -u http://10.10.90.196 -w /usr/share/wordlists/dirbuster/directory-list-2.3-medium.txt -o dirb.txt`



# search msfconsole for exploits

```
searchsploit cms made simple

CMS Made Simple < 1.12.1 / < 2.1.3 - Web Server Cache Poisoning                                                                                                                                                      | php/webapps/39760.txt
CMS Made Simple < 2.2.10 - SQL Injection <------- Using this one                                                                                                                                                     | php/webapps/46635.py
CMS Made Simple Module Antz Toolkit 1.02 - Arbitrary File Upload

# search google for php/webapps/46635.py and copy script locally
```