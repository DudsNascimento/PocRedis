#!/bin/bash
curl --header "Content-Length: 0" \
	--request POST \
	-v http://localhost:8080/loan;
