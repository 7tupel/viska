(ns brick.r2.next_test
  (:require
   [lazytest.core :refer [defdescribe describe specify expect before after]]))


(defdescribe get=color-token-test
  (describe get-color-token
    (specify ""
      (expect 
        (= 
          "blue"
          (get-color-token {:color {:blue {:default {:theme/default "blue"}}}} :blue))))))
