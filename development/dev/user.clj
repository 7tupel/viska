(ns user
  (:require
   [clj-reload.core :as reload]))

;;; Initialize development environment

;; Setup reloading
(reload/init {:no-reload '#{user}})

(require '[lazytest.repl])

(defn start
  "Start everything."
  []
  ::started)


;;; Repl utilities

(defn reload!
  "Reload everything that has changed."
  []
  (reload/reload))

;;; Start Development

(start)
(println "Everything is setup and ready for you")
(println "Happy Development 🐱")