# Assignment 4 Activity 1
## Description
The Performer has 6 different functions: adding strings into an array, clearing the array, finding a string at a specific index, displaying the array, sorting the array, prepending a string to the beginning of a string in the array at a specific index, and quitting. Task 2 is multithreaded and unbounded. Task 3 is multithreaded and bounded. 

## Protocol

### Requests
request: { "selected": <int: 1=add, 2=clear, 3=find, 4=display, 5=sort, 6=prepend
0=quit>, "data": <thing to send>}

  add: data <string> -- a string to add to the list, this should already mostly work
  clear: data <> -- no data given, clears the whole list
  find: data <string> -- display index of string if found, else -1
  display: data <> -- no data given, displays the whole list
  sort: data <> -- no data given, sorts the list
  prepend: data <int> <string> -- index and string, prepends given string to string at index

### Responses

success response: {"ok" : true, type": <String> "data": <thing to return> }

type <String>: echoes original selected from request
data <string>: 
    add: return current list
    clear: return empty list
    find: return integer value of index where that string was found or -1
    display: return current
    sort: return current list
    prepend: return current list


error response: {"ok" : false, "message"": <error string> }
error string: Should give good error message of what went wrong


## How to run the program
### Terminal
Base Code, please use the following commands:
```
    For Server, run "gradle runServer -Pport=9099 -q --console=plain"
``` For Server, run "gradle runTask1"
    For Server (multithreaded, unbounded), run "gradle runTask2"
    For Server (multithreaded, bounded), run "gradle runTask3" (2 threads)
```   
    For Client, run "gradle runClient -Phost=localhost -Pport=9099 -q --console=plain" or run "gradle runClient"
```   


Link: https://drive.google.com/file/d/1KcoQomtYAC3tkNb-PkcJd-Lh95Asbq6f/view?usp=sharing 
