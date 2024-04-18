const path = require('path')
const webpack = require('webpack')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const TerserPlugin = require('terser-webpack-plugin')
const BundleAnalyzerPlugin =
    require('webpack-bundle-analyzer').BundleAnalyzerPlugin
const dotenv = require('dotenv').config({ path: __dirname + '/.env' })
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin')

module.exports = {
    mode: 'production',
    entry: './src/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist'),
        publicPath: '/',
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.join(__dirname, 'public', 'index.html'),
        }),
        new BundleAnalyzerPlugin({ openAnalyzer: true }),
        new webpack.DefinePlugin({
            'process.env': JSON.stringify(dotenv.parsed),
        }),
        new MiniCssExtractPlugin(),
    ],
    optimization: {
        minimizer: [new CssMinimizerPlugin(), new TerserPlugin()],
    },
    resolve: {
        fallback: {
            fs: false,
            os: false,
            path: false,
        },
    },
    devServer: {
        historyApiFallback: true,
        static: {
            directory: path.join(__dirname, 'build'),
        },
        port: 3000,
        allowedHosts: 'all',
    },
    module: {
        // exclude node_modules
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                },
            },
            {
                test: /\.(png|jpe?g|gif|webp)$/i,
                use: [
                    {
                        loader: 'url-loader',
                    },
                ],
            },
            {
                test: /\.css$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                    'postcss-loader',
                ],
            },
        ],
    },
    // pass all js files through Babel
    resolve: {
        extensions: ['.*', '.js', '.jsx'],
    },
}
