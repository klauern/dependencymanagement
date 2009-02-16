/*
 * The below lines show a simple way to get at a JSON file and parse it out.
 * It's pretty easy.  Look at the SomeBootStrapInfo.json file in the docs/directory
 * and see for yourself how this is set up.  I plan on making this into the
 * BootStrap.groovy file, but I have some minor tweaking to do, as well as trying
 * to find the way to create relationships.
 *
 */

import grails.converters.*

def jsonArray = JSON.parse(new File("./docs/SomeBootStrapInfo.json").getText())
def contacts = jsonArray.get("Contacts")
contacts[1].toString()