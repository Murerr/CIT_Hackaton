import sys
import os

def main():
    
    lines = list()

    try:
        lines = fileRead("input.txt") if len(sys.argv) == 1 else fileRead(sys.argv[1])

    except FileNotFoundError as e:
        print(f'{e}')
        print('Try placing the input file in this directory:')
        print(f'{os.getcwd()}')
        exit(1)

    print(lines)


def fileRead(fileName):
    readFile = open(fileName, 'r')
    return readFile.read().splitlines()

if __name__ == "__main__":
    main()