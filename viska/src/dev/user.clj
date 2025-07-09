(ns user
  (:require
   [clj-reload.core :as reload]
   [shadow.cljs.devtools.server :as shadow-server]
   [shadow.cljs.devtools.api :as shadow]))

;; Setup reloading
(reload/init {:no-reload '#{user}})

;; Run to setup everything required to begin development.
(defn start
  {:shadow/requires-server true}
  []
  (shadow-server/start!)
  (shadow/watch :app)
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


;;; Utility functions for development

(defn reload!
  "Reload everything that has changed."
  []
  (reload/reload))




;;; Start Development

(start)
(println "Everything is setup and ready for you")
(println "Happy Development 🐱")