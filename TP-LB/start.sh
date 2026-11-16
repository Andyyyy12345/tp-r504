#!/bin/bash

# (a) Créer le réseau interne Docker nommé tplb
docker network create tplb

# (b) Construire l'image im-nginx-lb
docker build -t im-nginx-lb ./tp-A

# (c) Créer les deux sous-dossiers shared1 et shared2
mkdir -p shared1 shared2

# (d) Créer les fichiers index.html respectifs
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html

# (e) Lancer les deux serveurs web backend
docker run -d --rm --name nginx1 --network tplb -p 81:80 -v "$(pwd)/shared1":/usr/share/nginx/html nginx
docker run -d --rm --name nginx2 --network tplb -p 82:80 -v "$(pwd)/shared2":/usr/share/nginx/html nginx

# (f) Lancer le load balancer
docker run -d --rm --name nginx-lb --network tplb -p 83:80 im-nginx-lb
