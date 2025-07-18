(ns viska.ui
  (:require 
   [replicant.dom :as r]
   ;[viska.ui.button :as ui]
   ))

(defn main
  []
  (println "Hello World from UI")
  (println [:clojure {"yes" [:a :b :c]}])
  (let [root (js/document.getElementById "app")]
    (r/render 
      root
      [:h1 "Viska is awesome"]
      )))