# Break-Encryptor

So I decided to do some toying around with the math of the BETTER-Encryptor recently
to really mess with the program for fun. I wrote a bit of code to help make
a file to try and choke it up a bit.

overloader.java is my first addition to this repository to break my Better-Encryptor
by exploiting the new size of encrypted text.

The Math/Explanation (for more details about the encryptor go to the read-me file in BETTER-Encryptor):

    The way the new size of the encrypted text is calculated, is first by taking
    say we call the 'text to be encrypted length' = L, it finds the greatest prime factor
    of L, say we call this greatest factor G. The new size of what the encrypted text will be
    is then L x G.
    
    Notice that if L itself is prime then L = G. So the easiest way to exploit this is by trying
    encrypt a line with length equal to a large prime. Thus making the new size L^2. Generating
    random letters to append at this length then attempting a cypher shift on it via a corresponding
    array will obviously lead to the program choking up a fair amount even with a single line to encrypt.
    
    So what is overload.java doing? It first has 2 ways of taking user input first either via args[0] and
    args[1] or if args has length < 2 then it will prompt user input with a scanner.
    It then takes the value of args[0] (or first input via scanner) and calculates the largest possible prime
    less than or equal to the input. Then it takes args[1] (or second input via scanner). The calculated prime
    will become the length of each line in a created text file 'overload.txt' and the args[1] value will be the
    desired number of lines in 'overload.txt'.
    
    So for example after compiling, if I call "java overloader 333 10" it will calculate the largest prime below
    333 which is 331 and creates a file called 'overload.txt' that has 10 lines, each line containing 331 '0'.
    
    You can then use this file in runEncryption.java from BETTER-Encryptor and watch the code crawl to work if at all!
    You can also simply create the file with 1 line rather than 10, copy paste the text in the file, then encrypt it
    with your own Encrptor caller file and expect a slow result.
    
    
