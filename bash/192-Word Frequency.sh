#!/usr/bin/env bash

sed -r 's/\s+/\n/g' words.txt | grep -v "^$" | sort | uniq -c | sort -r | awk '{print $2" "$1}'