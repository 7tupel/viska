(ns tasks
  (:require
   [babashka.fs :as fs]
   [proc-wrapper :refer [wrap-process]]
   [clojure.string :as str]))


;;; not this package ;;;;

(defn closeable
  ([value] (closeable value identity))
  ([value close] (reify
                   clojure.lang.IDeref
                   (deref [_] value)
                   java.io.Closeable
                   (close [_] (close value)))))

(defn desktop-start-portfolio
  []
  (wrap-process
    "npx shadow-cljs watch portfolio"
    {:dir "./../desktop"}))

(comment
  (future-call (desktop-start-portfolio))
  )


;;;;

(defn nrepl
  [opts]
  ;; run the Clojure nRepl server
  (wrap-process
    "clj -M:nREPL -m nrepl.cmdline --middleware \"[clj-commons.pretty.nrepl/wrap-pretty]\""
    {}))

(defn start-desktop-app
  [opts]
  ;; run the full desktop app with everything here
  )