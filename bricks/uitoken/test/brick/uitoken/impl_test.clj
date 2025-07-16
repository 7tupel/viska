(ns brick.uitoken.impl-test
  (:require 
   [lazytest.core :refer [defdescribe describe specify expect before after]]
   [brick.uitoken.impl :refer [tokens* assoc-token deftoken get-color-token]]))

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
    (specify "Add a new color token, default theme, default variant."
      (expect
        (=
          {:color {:secondary {:default {:theme/default "pink"}}}}
          (deftoken :color :secondary "pink"))))
    (specify "Add a newcolor token, default variant, dark theme."
      (expect
        (=
          {:color {:secondary {:default {:theme/default "pink" :theme/dark "lavender"}}}}
          (deftoken :color :secondary "lavender" :theme :dark))))
    (after (reset! tokens* {}))))



(defdescribe get=color-token-test
  (describe get-color-token
    (specify ""
      (expect 
        (= 
          "blue"
          (get-color-token {:color {:blue {:default {:theme/default "blue"}}}} :blue))))))
