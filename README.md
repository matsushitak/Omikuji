# Omikuji

# アプリの開発について

## 開発手法

http://www.eda-inc.jp/post-106/

## 設計

ざっくり大きく分けると以下の分類になる。
MVVMが一番おおい。

* MVC
https://qiita.com/shinkuFencer/items/f2651073fb71416b6cd7
* MVP
https://android.benigumo.com/20160729/android-architecture-blueprints/
* MVVM
https://blog.fenrir-inc.com/jp/2014/04/mvvm-for-android.html

## Try Kotlin

* ブラウザでKotlinが試せるツール
* 文法も確認することができる
https://try.kotlinlang.org/#/Examples/Basic%20syntax%20walk-through/

# おみくじアプリをつくってみよう

## ビルド設定

* アプリのビルドを設定を説明
* build.gradleのファイルの設定について
https://developer.android.com/studio/build/build-variants.html?hl=ja

## Modelを実装

### モデルクラス

* 通信レスポンスごとに必要となる

### 通信クラス

* 通信処理を行う

### リポジトリクラス

* モデルデータを永続化もしくはメモリキャッシュする

### ここで利用するライブラリ

### Moshi

Json文字列をモデルに変換するためのライブラリ
https://github.com/square/moshi

### Retrofit
通信処理を簡単に実装できるライブラリ
http://square.github.io/retrofit/

## ViewModelを実装

### ビューモデルクラス

* 画面ごとに作成が必要
* Viewに必要なメソッドを実装する

## ここで利用するライブラリ

### DataBinding

ViewにViewModelの状態をバインドするためのライブラリ
https://developer.android.com/topic/libraries/data-binding/index.html?hl=ja

## Viewを実装

### アセットを追加

* ここからアセットをダウンロードしてください
https://github.com/trickring/Omikuji/tree/master/app/src/main/res

### レイアウトを実装

* レイアウトを設定するためのxmlを編集する

### Controllerを実装

* ActivityまたはFragmentを実装する

