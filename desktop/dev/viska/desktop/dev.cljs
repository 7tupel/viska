(ns viska.desktop.dev
  (:require
   [viska.desktop.core :as app]))

(def store (atom nil))

(defn ^:dev/after-load configure []
  ;(dataspex/inspect "Game state" store)
  (app/main store))

(defn main []
  (configure)
  ;; Trigger the first render by initializing the game.
  ;;(tic-tac-toe/start-new-game store)
  )