#!/bin/bash

c1=0
c2=0

for ((i=1; i<=500; i++)); do
    rep=$(curl -s http://localhost:83)
    if [[ "$rep" == *"Hello 1"* ]]; then
        ((c1++))
    elif [[ "$rep" == *"Hello 2"* ]]; then
        ((c2++))
    fi
done

echo "Réponses serveur 1 (nginx1) : $c1"
echo "Réponses serveur 2 (nginx2) : $c2"
