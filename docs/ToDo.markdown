To-Do List for Dependency Management application:
=================================================

Architecture Modeling Requirements
----------------------------------
	1. Add the Support detail table to tie-in the Integration components.
	
Scaffolding Requirements
------------------------
   1. include the [inList()][1] components in all relevant domain
	   models.  This will simplify the need for error-prone entries on common,
	   repetetive field types (JCAPS, etc.)
   2. Add descriptions to every element in the add form.
   3. Create a process-flow to define how one would move from one controller
       element to another.
   4. Create a controller to handle an all-in-one Integration add-in.  This will
        include being able to add in-place any ancillary domain pieces while
        building a coherent integration piece.  This, in turn will allow future
        add-ins to reuse the all-in-one approach with pre-entered fields.


Miscellaneous
-------------
   1. Add more basic bootstrapping for the model:
		* Domain
		* Zone
		* Port
		* Vendor
		* Event
	   The more bootstrapping we can do on the front-end, the easier it will
       look to us for accuracy.
	2. Create a file-reader that will take in a .csv file and attempt to map it
       to the model.  Potentially unsafe, insecure, etc., but might offer a way
       to simplify entry.




References
----------
  [1]: http://grails.org/doc/1.0.x/ref/Constraints/inList.html