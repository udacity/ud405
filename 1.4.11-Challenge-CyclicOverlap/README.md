# Cyclic Overlap

Usually the painter's algorithm works out fine. Shapes drawn later appear over top of shapes drawn earlier, and that's the end of it.
 
However, there's an interesting condition called cyclic overlap. It mostly comes up in 3D applications, but consider three shapes: RED, GREEN, and BLUE. Part of GREEN is on top of RED, part of BLUE is on top of GREEN, and part of RED is on top of BLUE. In what order do we draw these shapes?
  
Check out the TODOs to get a closer look at the problem, and to add hacky fix.
