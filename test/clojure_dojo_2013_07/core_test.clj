(ns clojure-dojo-2013-07.core-test
  (:require [clojure.test :refer :all]
            [clojure-dojo-2013-07.core :refer :all]))

(deftest I+I=2
  (is (= "II" (add "I" "I"))))

(deftest I+V=VI
  (is (= "VI" (add "I" "V"))))

(deftest II+III=V
  (is (= "V" (add "II" "III"))))

(deftest III+III+III+III=XII
  (is (= "XII" (add "III" (add "III" (add "III" "III"))))))

