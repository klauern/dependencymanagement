To-Do List for Dependency Management application:
=================================================

Architecture Modeling Requirements
----------------------------------
	1. Add the Support detail table to tie-in the Integration components.
	
Scaffolding Requirements
------------------------
	1. include the [inList()][] components in all relevant domain
	   models.  This will simplify the need for error-prone entries on common,
	   repetetive field types (JCAPS, etc.)
	2. Add descriptions to every element in the add form.
	3. Create a process-flow to define how one would move from one controller
       element to another.
       * Define the start page, some basic layouts and how the CSS will
         format.
	4. 
	
Miscellaneous
-------------
    1. Add more basic bootstrapping for the model:
		* Domain
		* Zone
		* Port
		* Vendor
		* Event
	   The more bootstrapping we can do on the front-end, the easier it will look to us for accuracy.
	2. Create a file-reader that will take in a .csv file and attempt to map it to the model.  Potentially unsafe, insecure, etc., but might offer a way to simplify entry.
	
	
	
	
References
----------
[inList()]: http://grails.org/doc/1.0.x/ref/Constraints/inList.html