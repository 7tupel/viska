(ns user
  (:require
   [clj-reload.core :as reload]
   [bling.core :refer [print-bling]]
   [babashka.process :refer [process]]))

;;; Initialize development environment

;; Setup reloading
(reload/init {:no-reload '#{user}})

(require '[lazytest.repl])


(defonce processes (atom {}))

(defn- run-webapp
  []
  ;; watch and build electron app and browser code
  (println "to be implemented..."))

(defn- run-portfolio
  []
  ;; watch and run portfolio
  (let [p (process {:dir "./../viska"} "npx shadow-cljs watch portfolio")])
  (println "to be implemented..."))

(comment 
  (def p (process {:dir "./../desktop"} "npx shadow-cljs watch portfolio"))
  
  (def a (process {:dir "./../desktop"} "npx shadow-cljs watch app"))
  
 
  
  p
  run-portfolio)

(defn run
  [k &args]
  (case k
    :portfolio (run-portfolio)))

(defn start
  "Start everything."
  []
  ::started)



;;; Repl utilities

(defn reload!
  "Reload everything that has changed."
  []
  (reload/reload))

(defn print-welcome
  []
  (println "")
  (print-bling [:bold.blue "Welcome to the Development project for"] " " [:bold.italic.purple "Viska"])
  (println)
  (print-bling [:gray "The elfs are setting everything up to get you started."] "\n"))

(defn print-ready
  []
  (print-bling [:gray "Everything is setup and ready for you"])
  (print-bling [:gray "Happy Development"] " " [:yellow "🐱"] "\n"))



;;; Start Development

(print-welcome)
(start)
(print-ready)