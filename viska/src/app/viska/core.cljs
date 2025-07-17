(ns viska.core
  (:require [replicant.dom :as r]))

(defn main
  []
  (println "Hello World from UI")
  (println [:clojure {"yes" [:a :b :c]}])
  (let [root (js/document.getElementById "app")]
    (r/render root [:h1 "Viska is awesome"])))