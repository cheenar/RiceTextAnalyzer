////////////////////
RICE
////////////////////

////////////////////
INTRODUCTION
////////////////////
Rice is a text analyzer that uses basic machine learning to try and 
match poems with authors by using previous data. While the machine
learning currently is primitive, there is room for improvement and that
improvement can be done very soon.

////////////////////
COMMANDS
////////////////////
exit
analyze [text_file_name_with_extension]

////////////////////
HOW TO USE
////////////////////
To use Rice, just run the source code, there are no advanced libraries,
not build scripts, just drop and run. The command system is fairly basic.

You will also need to setup a configuration file with the Author information and
the linking to the text files. Its actually prety easy to figure out the syntax by
looking at the file so need for much explaination. The included configuration is called
configuration.chnr and can be editted to your input. 

1) Run rice
2) analyze test.ctxt
3) This will run the modules on the test.ctxt poem and will tell you the results, you can 
   answer "Y" or "N" for the result and then enter the authors name (no error however)
4) Run and keep changing the test.ctxt (file dynamic changes will be taken into affect) 
   and continue until you've tested atleast 12 times.