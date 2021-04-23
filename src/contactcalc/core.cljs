(ns contactcalc.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [mathjs :as m]))

;; -------------------------
;; diagrams

(defn figure8 [num den]
  [:svg {:width "10.85in", :height "7.3761in", :version "1.1", :viewbox "0 0 275.59 187.35", :xmlns "http://www.w3.org/2000/svg"}
   [:g {:transform "translate(-49.5 -142.45)"}
    [:g {:fill "none", :stroke "#000", :stroke-width "4.1862"}
     [:path {:d "m163.58 192.34c-12.758 11.953-24.03 20.463-38.5 20.463 12.825 0 90.924 77.644 148.26 79.24-22.791 0-69.177 35.496-106.67 35.661-41.062 0.18059-103.98-38.032-117.17-38.032 14.001 0 39.001-6.4602 53.823-11.634"}]
     [:path {:d "m220.6 271.91c4.711-8.8383 41.138-47.606 58.749-48.745-17.778 0-61.717-42.95-89.627-42.95-7.4398 0-16.312 0.51996-22.362 7.4848"}]
     [:path {:d "m192.7 255.76c10.638-8.663 25.489-39.923 35.481-57.261"}]
     [:path {:d "m111.76 274.98c12.508-4.1892 18.963-6.3917 30.044-12.72"}]
     [:path {:d "m149.05 258.23c7.4074-4.0106 12.105-9.305 17.801-13.458"}]
     [:path {:d "m172.66 240.28c9.9622-8.7949 20.951-28.115 37.886-28.815-18.857 0-45.17-31.05-74.493-31.346-10.923 0-27.282 10.132-27.282 10.132"}]
     [:path {:d "m97.117 196.17s-27.774 23.488-42.203 23.488c20.019 0 60.199 89.311 110.17 90.694 30.187 0 44.823-18.414 52.455-31.899"}]
     [:path {:d "m230.64 193.13c7.3535-11.916 25.125-27.602 43.94-27.602-17.449 0-73.629-22.073-111.39-20.951-28.637 0.85123-66.284 20.876-83.374 20.876 20.142 0 47.183 103.24 86.788 104.01 7.7935-0.0386 21.177-9.9085 21.177-9.9085"}]]
    [:text {:x "297.08456", :y "228.8149", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"} "(2)"]
    [:path {:d "m294.4 165.32h20.997", :fill "none", :stroke "#000", :stroke-width "1.3954"}]
    [:text {:x "299.98947", :y "161.39523", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"} num]
    [:text {:x "294", :y "180.85577", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"} den]
    [:path {:d "m289.14 150.03c-4.6672 9.6086-5.3028 20.128 0 31.988", :fill "none", :stroke "#000", :stroke-width "1.3954"}]
    [:path {:d "m320.66 149.85c4.6672 9.6086 5.3028 20.128 0 31.988", :fill "none", :stroke "#000", :stroke-width "1.3954"}]]])

(defn whitehead [coeff]
  [:svg {:width "24.49in", :height "7.3761in", :version "1.1", :viewbox "0 0 622.06 187.35", :xmlns "http://www.w3.org/2000/svg"}
   [:g {:transform "translate(-2.9527 -4.6884)"}
    [:g {:fill "none", :stroke "#000", :stroke-width "4.1862"}
     [:path {:d "m117.03 54.584c-12.758 11.953-24.03 20.463-38.5 20.463 12.825 0 90.924 77.644 148.26 79.24-22.791 0-69.177 35.496-106.67 35.661-41.062 0.18059-103.98-38.032-117.17-38.032 14.001 0 39.001-6.4602 53.823-11.634"}]
     [:path {:d "m174.05 134.15c4.711-8.8383 41.138-47.606 58.749-48.745-17.778 0-61.717-42.95-89.627-42.95-7.4398 0-16.312 0.51996-22.362 7.4848"}]
     [:path {:d "m146.15 118c10.638-8.663 25.489-39.923 35.481-57.261"}]
     [:path {:d "m65.212 137.22c12.508-4.1892 18.963-6.3917 30.044-12.72"}]
     [:path {:d "m102.51 120.47c7.4074-4.0106 12.105-9.305 17.801-13.458"}]
     [:path {:d "m126.12 102.52c9.9622-8.7949 20.951-28.115 37.886-28.815-18.857 0-45.17-31.05-74.493-31.346-10.923 0-27.282 10.132-27.282 10.132"}]
     [:path {:d "m50.57 58.41s-27.774 23.488-42.203 23.488c20.019 0 60.199 89.311 110.17 90.694 30.187 0 44.823-18.414 52.455-31.899"}]
     [:path {:d "m184.09 55.376c7.3535-11.916 25.125-27.602 43.94-27.602-17.449 0-73.629-22.073-111.39-20.951-28.637 0.85123-66.284 20.876-83.374 20.876 20.142 0 47.183 103.24 86.788 104.01 7.7935-0.0386 21.177-9.9085 21.177-9.9085"}]]
    [:text {:x "250.53752", :y "91.056412", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "250.53752", :y "91.056412", :stroke-width ".3692"} "(4)"]]
    [:path {:d "m247.85 27.563h20.997", :fill "none", :stroke "#000", :stroke-width "1.3954"}]
    [:text {:x "253.44243", :y "23.636745", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "253.44243", :y "23.636745", :stroke-width ".3692"} coeff.d]]
    [:text {:x "246.10899", :y "43.09729", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "246.10899", :y "43.09729", :stroke-width ".3692"} (- coeff.d coeff.n)]]
    [:g {:fill "none", :stroke "#000"}
     [:path {:d "m242.59 12.272c-4.6672 9.6086-5.3028 20.128 0 31.988", :stroke-width "1.3954"}]
     [:path {:d "m274.11 12.094c4.6672 9.6086 5.3028 20.128 0 31.988", :stroke-width "1.3954"}]
     [:g {:stroke-width "4.1862"}
      [:path {:d "m462.94 54.584c-12.758 11.953-24.03 20.463-38.5 20.463 12.825 0 90.924 77.644 148.26 79.24-22.791 0-69.177 35.496-106.67 35.661-41.062 0.18059-103.98-38.032-117.17-38.032 14.001 0 39.001-6.4602 53.823-11.634"}]
      [:path {:d "m519.97 134.15c4.711-8.8383 41.138-47.606 58.749-48.745-17.778 0-61.717-42.95-89.627-42.95-7.4398 0-16.312 0.51996-22.362 7.4848"}]
      [:path {:d "m492.06 118c10.638-8.663 25.489-39.923 35.481-57.261"}]
      [:path {:d "m411.12 137.22c12.508-4.1892 18.963-6.3917 30.044-12.72"}]
      [:path {:d "m448.42 120.47c7.4074-4.0106 12.105-9.305 17.801-13.458"}]
      [:path {:d "m472.03 102.52c9.9622-8.7949 20.951-28.115 37.886-28.815-18.857 0-45.17-31.05-74.493-31.346-10.923 0-27.282 10.132-27.282 10.132"}]
      [:path {:d "m396.48 58.41s-27.774 23.488-42.203 23.488c20.019 0 60.199 89.311 110.17 90.694 30.187 0 44.823-18.414 52.455-31.899"}]
      [:path {:d "m530 55.376c7.3535-11.916 25.125-27.602 43.94-27.602-17.449 0-73.629-22.073-111.39-20.951-28.637 0.85123-66.284 20.876-83.374 20.876 20.142 0 47.183 103.24 86.788 104.01 7.7935-0.0386 21.177-9.9085 21.177-9.9085"}]]]
    [:text {:x "590.44952", :y "91.056396", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "590.44952", :y "91.056396", :stroke-width ".3692"} "(" (- coeff.n coeff.d) "/" coeff.d ")"]]
    [:path {:d "m600.43 27.563h13.677", :fill "none", :stroke "#000", :stroke-width "1.4"}]
    [:text {:x "602.35437", :y "23.636745", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "602.35437", :y "23.636745", :stroke-width ".3692"} "1"]]
    [:text {:x "602.05481", :y "43.097286", :fill "#000000", :font-family "sans-serif", :font-size "14.768px", :stroke-width ".3692", :xml:space "preserve"}
     [:tspan {:x "602.05481", :y "43.097286", :stroke-width ".3692"} "4"]]
    [:g {:fill "none", :stroke "#000"}
     [:path {:d "m588.51 12.272c-4.6672 9.6086-5.3028 20.128 0 31.988", :stroke-width "1.3954"}]
     [:path {:d "m620.02 12.094c4.6672 9.6086 5.3028 20.128 0 31.988", :stroke-width "1.3954"}]
     [:path {:d "m591.07 27.563h6.3576", :stroke-width "1.355"}]]]])

;; -------------------------
;; contact-calculators

(defn make-negative [num]
  (cond
    (m/equal (m/floor num) num) (m/fraction "-1")
    (m/smaller num 0) num
    :else (recur (m/fraction (m/subtract num.n num.d) num.d))))

(defn make-small [num]
  (let [floor (m/floor num)]
    (if (m/equal floor num) (m/fraction 1) (m/subtract num floor))))

(defn euclidean
  "Extended Euclidean Algorithm. Returns [gcd(a,b) x y] where ax + by = gcd(a,b)."
  [a b]
  (if (= a 0)
    [0 1]
    (let [[x y] (euclidean (mod b a) a)]
      [(- y (* (m/floor (m/divide b a)) x)) x])))

(defn cfb-calc
  ([num vec past] (let [floor (m/floor num) now (js/Date.now)]
                    (cond
                      (m/largerEq num 0) (recur (make-negative num) [] past)
                      (m/equal floor num) (conj vec floor) ;; return list
                      :else (if (> (- now past) 3000)
                              (throw (js/Error. "timeout"))
                              (recur (m/divide 1 (m/subtract floor num)) (conj vec floor) past)))))
  ([num past] (cfb-calc num [] past)))

(defn solid-torus [meridian dividing past]
  (cond
    (= dividing "inf") (let [lst (cfb-calc (. (. (make-small meridian) inverse) neg) past)]
                         (m/abs (reduce m/multiply (first lst) (map #(m/add % 1) (rest lst)))))
    (= meridian "inf") (let [lst (cfb-calc (. (make-negative dividing) inverse) past)]
                         (m/abs (reduce m/multiply (first lst) (map #(m/add % 1) (rest lst)))))
    :else (solid-torus (. (m/subtract dividing meridian) inverse) "inf" past)))

(defn f8-calc [num past]
  (cond (or (m/equal num 0) (m/equal num -4) (m/equal num 4)) "∞"
        (or (and (m/larger num 4) (m/smaller num 5)) (and (m/largerEq num -4) (m/smaller num -3))) "not known yet."
        (m/larger num 0) (let [lst (cfb-calc (. (. (make-small num) inverse) neg) past)]
                           (str (m/multiply 2 (m/abs (reduce m/multiply (first lst) (map #(m/add % 1) (rest lst)))))))
        (m/smaller num -4) (let [lst1 (cfb-calc (. (. (make-small num) inverse) neg) past) lst2 (cfb-calc (m/add num 3) past)]
                             (str (m/add (m/abs (reduce m/multiply (first lst1) (map #(m/add % 1) (rest lst1)))) (m/abs (reduce m/multiply (first lst2) (map #(m/add % 1) (rest lst2)))))))
        :else (let [lst (cfb-calc (. (. (make-small num) inverse) neg) past)]
                (str (m/abs (reduce m/multiply (first lst) (map #(m/add % 1) (rest lst))))))))

(defn whitehead-calc [num past]
  (str (m/add (m/multiply 2 (solid-torus num "inf" past)) (solid-torus num 1 past))))

(defn sfs-calc [num] "not yet implemented")
(defn lens-calc [num] "not yet implemented")
(defn solid-calc [num] "not yet implemented")

;;실행시간 3초 넘으면 프로세스 죽여야함 ("Sorry. It takes too much time!")
(defn contact-calc [contact-data draw?]
  (let [past (js/Date.now)]
    (try
      (cond
        (false? @draw?) nil
        (= (@contact-data :category) "figure8") [:p "The number of tight contact structure is " (f8-calc (m/fraction (@contact-data :value)) past)]
        (= (@contact-data :category) "whitehead") [:p "The number of tight contact structure is " (whitehead-calc (m/fraction (@contact-data :value)) past)]
        (= (@contact-data :category) "lens") [:p "The number of tight contact structure is " (lens-calc (m/fraction (@contact-data :value)))]
        (= (@contact-data :category) "sfs") [:p "The number of tight contact structure is " (sfs-calc (m/fraction (@contact-data :value)))]
        (= (@contact-data :category) "solid") [:p "The number of tight contact structure is " (solid-calc (m/fraction (@contact-data :value)))]
        :else val)
      (catch js/Error e [:p "Sorry, it takes too much time.. or"]))))


;; ------------------------- 
;; Views

(defn diagram-component [contact-data draw?]
  (try
    (let [coeff (m/fraction (@contact-data :value)) cat (@contact-data :category)]
      (cond (false? @draw?) nil
            (= cat "figure8") (cond (m/equal coeff 1) [figure8 "1" "0"]
                                    (or (m/smallerEq coeff 0) (and (m/largerEq coeff 4) (m/smaller coeff 5)) (and (m/largerEq coeff -4) (m/smaller coeff -3))) nil
                                    :else (let [r (. (m/subtract 1 coeff) inverse)] [figure8 (str r.n) (str r.d)]))
            (= cat "whitehead") [whitehead coeff]
            :else nil))
    (catch js/Error e [:p "invalid input"])))

(defn temp-select [contact-data draw?]
  [:select {:on-change #((reset! contact-data {:value (@contact-data :value) :category (-> % .-target .-value)})
                         (reset! draw? false))}
   [:option {:value "figure8"} "Surgeries on the figure-8 knot"]
   [:option {:value "whitehead"} "Surgeries on the Whitehead link"]
   [:option {:value "sfs"} "Small Seifert fibrations"]
   [:option {:value "lens"} "Lens spaces"]
   [:option {:value "solid"} "solid tori"]])

(defn contact-form [val contact-data draw?]
  [:form {:on-submit #((.preventDefault %)
                       (reset! contact-data {:value @val :category (@contact-data :category)})
                       (reset! val "")
                       (reset! draw? true))}
   [:input {:type "text"
            :value @val
            :placeholder "Type a surgery coefficient"
            :on-change #(reset! val (-> % .-target .-value))}]])

(defn references [contact-data draw?]
  (let [cat (@contact-data :category)]
    (cond
      (false? @draw?) nil
      (= cat "figure8") [:p "references: " [:a {:href "https://arxiv.org/abs/1901.06066"} "arxiv:1901.06066"]]
      (= cat "whitehead") [:p "references: "]
      (= cat "sfs") [:p "refernces: sfs"]
      (= cat "lens") [:p "refernces: lens"]
      (= cat "solid") [:p "refernces: solid"])))

(defn contact-component []
  (let [val (r/atom "") contact-data (r/atom {:value "5" :category "figure8"}) draw? (r/atom false)]
    (fn []
      [:div
       [temp-select contact-data draw?]
       [contact-form val contact-data draw?]
       [references contact-data draw?]
       [contact-calc contact-data draw?]
       [diagram-component contact-data draw?]])))


(defn home-page []
  [:div
   [:h4 "3d Contact Calculator"]
   [contact-component]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
