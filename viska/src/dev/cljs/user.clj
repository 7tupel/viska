(ns cljs.user
  (:require
   [shadow.cljs.devtools.server :as shadow-server]
   [shadow.cljs.devtools.api :as shadow]))

;; Run to setup everything required to begin development.
(defn start
  {:shadow/requires-server true}
  []
  (shadow-server/start!)
  (shadow/watch :app)
  (shadow/watch :app-ui)
  (shadow/watch :portfolio)
  ::started)

(defn stop
  "Stop everything."
  []
  ::stopped)

(defn restart
  "Gracefully restart."
  []
  (stop)
  (start))


;;; Start Development

(start)
(println "Everything is setup and ready for you")
(println "Happy Development 🐱")