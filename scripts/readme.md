#### Scripts

getimages - gets all the images from a website 

`wget -r -np -nd -k http://$IP`

usage: 

`getimages 10.10.201.22`

gobuster - search for hidden directories

`gobuster dir -u http://$IP -w /usr/share/wordlists/dirb/common.txt -t 4 -o dirb.txt`

usage: 

`gobuster 10.10.201.22`


nmap - run nmap on the site

`nmap -sC -A -vv $IP`

usage: 

`nmap 10.10.201.22`