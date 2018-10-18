#!/usr/bin/env bash

sed -r 's/\s+/\n/g' poem.txt | grep -v "^$" | sort | uniq -c | sort -r | sed -n 1,10p | awk '{print $2" "$1}'
