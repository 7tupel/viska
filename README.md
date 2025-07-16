# Viska

Viska shows you the result of your pipeline.


## Development

### Repository Structure

Viska and all its parts are developed in this single Monorepo. The structure of the repo resembles the Polylith architecture. The repo structure is as follows:

#### bricks/

Holds all bricks used by viska. 

_Brick are an encapsulated blocks of code that can be assembled together to build a shippable artifact like an application or a library_

#### viska/

The main user facing application build with ClojureScript and Electron.

#### development/

The development project is where all parts come together. All Clojure parts of the repo are loaded into this single project and allow interactive development running a Repl. 

Use this to start development.

_ClojureScript is not part of the development scope. _