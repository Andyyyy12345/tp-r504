#!/bin/bash

# Arrêt des 3 conteneurs
docker stop nginx1 nginx2 nginx-lb

# Suppression explicite (utile si l'option --rm n'avait pas été mise au lancement)
docker rm nginx1 nginx2 nginx-lb 2>/dev/null

# Suppression du réseau interne
docker network rm tplb
