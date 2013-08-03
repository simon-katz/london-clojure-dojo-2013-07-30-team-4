(ns clojure-dojo-2013-07.core)

(def conversion-map {\I 1
                     \V 5
                     \X 10
                     \L 50
                     \C 100
                     \D 500
                     \M 1000})

(defn call-until-no-change [f v]
  (loop [current v]
    (let [next (f current)]
      (if (= next current)
        current
        (recur next)))))

(def equivalents [["IIIII" "V"]
                  ["VV" "X"]
                  ["XXXXX" "L"]
                  ["LL" "C"]
                  ["CCCCC" "D"]
                  ["DD" "M"]])

(defn collapse [s]
  (reduce (fn [v [uncollapsed collapsed]]
            (call-until-no-change #(clojure.string/replace %
                                                           uncollapsed
                                                           collapsed)
                                  v))
          s
          equivalents))

(defn add [x y]
  (collapse
   (apply str
          (sort-by conversion-map
                   >
                   (str x y)))))

