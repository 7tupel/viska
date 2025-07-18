(ns viska.scenes
  (:require 
   [portfolio.ui :as portfolio]
   [portfolio.replicant :refer-macros [defscene]]
   [viska.ui.button :as btn]))


(defscene headlines
  ;[:h1 "Hello"]
  (btn/headline {})
  )

(defscene foobar
  [:h4 "Fubar"]
  )



(defn main 
  []
  (portfolio/start!
   {:config
    {:css-paths ["styles.css"]
     :viewport/defaults
     {:background/background-color "#fdeddd"}}}))