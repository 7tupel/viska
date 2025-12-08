(ns viska.desktop.scenes
  (:require
   [portfolio.ui :as portfolio]
   [portfolio.replicant :refer-macros [defscene]]
   [viska.desktop.ui.components :as ui]))


(defscene headline
  (ui/render-headline "Hello"))

(defn main []
  (portfolio/start!
   {:config
    {:css-paths ["/styles.css"]
     :viewport/defaults
     {:background/background-color "#fdeddd"}}}))