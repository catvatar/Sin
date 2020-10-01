#!/usr/bin/env python3
import sys

def fibonacci(n):
   if n > 1:
       return(fibonacci(n-1) + fibonacci(n-2))
   else:
       return n

def main():
    if len(sys.argv) < 2:
        print("Usage: fibonacci.py <number of rounds>")
        exit(1)
    num = int(sys.argv[1])
    
    if num <= 0:
        print("Error: Only positive integer is allowed!")
    else:
        for i in range(num):
            print(fibonacci(i))
       
if __name__ == '__main__':
    main()
