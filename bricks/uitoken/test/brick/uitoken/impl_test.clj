(ns brick.uitoken.impl-test
  (:require 
   [lazytest.core :refer [defdescribe describe specify expect before after]]
   [brick.uitoken.impl :refer [tokens* assoc-token deftoken]]))

(defdescribe assoc-token-test
  (describe assoc-token
    (specify "Add new token"
      (expect 
        (= 
          {:color {:primary {:default {:theme/light "yellow"}}}}
          (assoc-token {} :color :primary "yellow" :default :theme/light ))))
    (specify "Add new theme to token"
      (expect
        (=
          {:color {:primary {:default {:theme/default "yellow" :theme/light "green"}}}}
          (assoc-token {:color {:primary {:default {:theme/default "yellow"}}}} :color :primary "green"  :default :theme/light))))
    (specify "Add new variant to token"
      (expect
        (=
          {:color {:primary {:default {:theme/default "green"} 600 {:theme/light "red"}}}}
          (assoc-token {:color {:primary {:default {:theme/default "green"}}}} :color :primary "red" 600 :theme/light))))))



(defdescribe deftoken-test
  (describe deftoken
    (before (reset! tokens* {}))
    (specify ""
      (expect
        (=
          {:color {:secondary {:default {:theme/default "pink"}}}}
          (deftoken :color :secondary "pink")))
      (expect
        (=
          {:color {:secondary {:default {:theme/default "pink" :theme/dark "lavender"}}}}
          (deftoken :color :secondary "lavender" :theme :dark)))
      )
    (after (reset! tokens* {}))
    ))