(ns clojure-dojo-2013-07.core)

(def conversion-map {\I 1
                     \V 5
                     \X 10
                     \L 50
                     \C 100
                     \D 500
                     \M 1000})

(defn collapse [s]
  (loop [current s]
    (let [next (clojure.string/replace current "IIIII" "V")]
      (if (= next current)
        current
        (recur next)))))

                   ;; "IIIII" "V"
                   ;; "VV" "X"
                   ;; "XXXXX" "L"
                   ;; "LL" "C"
                   ;; "CCCCC" "D"
                   ;; "DD" "M"

(def numerals [\I \V \X \L \C \D \M])


(defn add [x y]
  (collapse
   (apply str
          (sort-by conversion-map
                   >
                   (str x y)))))

